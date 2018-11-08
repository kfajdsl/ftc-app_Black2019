package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.DogeCVDetector;
import com.disnodeteam.dogecv.filters.DogeCVColorFilter;
import com.disnodeteam.dogecv.filters.LeviColorFilter;
import com.disnodeteam.dogecv.scoring.MaxAreaScorer;
import com.disnodeteam.dogecv.scoring.PerfectAreaScorer;
import com.disnodeteam.dogecv.scoring.RatioScorer;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victo on 9/17/2018.
 * Modified by Sahan Reddy on 11/8/2018
 */

public class GoldPositionDetector extends DogeCVDetector {

    public enum GoldPosition {
        LEFT,
        MIDDLE,
        RIGHT,
        NOT_FOUND
    }

    // Defining Mats to be used.
    private Mat displayMat = new Mat(); // Display debug info to the screen (this is what is returned)
    private Mat workingMat = new Mat(); // Used for preprocessing and working with (blurring as an example)
    private Mat maskYellow = new Mat(); // Yellow Mask returned by color filter
    private Mat hierarchy  = new Mat(); // hierarchy used by coutnours

    // Results of the detector
    private boolean found    = false; // Is the gold mineral found
    private double  goldXPos = 0;     // X Position (in pixels) of the gold element
    private double  goldYPos = 0;     // Y Position (in pixels) of the gold element
    private GoldPosition curGoldPos = GoldPosition.NOT_FOUND;
    private GoldPosition lastGoldPos = curGoldPos;

    // Detector settings
    public boolean debugAlignment = true; // Show debug lines to show alignment settings

    public DogeCV.AreaScoringMethod areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Setting to decide to use MaxAreaScorer or PerfectAreaScorer


    //Create the default filters and scorers
    public DogeCVColorFilter yellowFilter      = new LeviColorFilter(LeviColorFilter.ColorPreset.YELLOW); //Default Yellow filter

    public RatioScorer       ratioScorer       = new RatioScorer(1.0, 3);          // Used to find perfect squares
    public MaxAreaScorer     maxAreaScorer     = new MaxAreaScorer( 0.01);                    // Used to find largest objects
    public PerfectAreaScorer perfectAreaScorer = new PerfectAreaScorer(5000,0.05); // Used to find objects near a tuned area value



    /**
     * Simple constructor
     */
    public GoldPositionDetector() {
        super();
        detectorName = "Gold Align Detector"; // Set the detector name
    }


    @Override
    public Mat process(Mat input) {

        // Copy the input mat to our working mats, then release it for memory
        input.copyTo(displayMat);
        input.copyTo(workingMat);
        input.release();


        //Preprocess the working Mat (blur it then apply a yellow filter)
        Imgproc.GaussianBlur(workingMat,workingMat,new Size(5,5),0);
        yellowFilter.process(workingMat.clone(),maskYellow);

        //Find contours of the yellow mask and draw them to the display mat for viewing

        List<MatOfPoint> contoursYellow = new ArrayList<>();
        Imgproc.findContours(maskYellow, contoursYellow, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(displayMat,contoursYellow,-1,new Scalar(230,70,70),2);

        // Current result
        Rect bestRect = null;
        double bestDiffrence = Double.MAX_VALUE; // MAX_VALUE since less diffrence = better

        // Loop through the contours and score them, searching for the best result
        for(MatOfPoint cont : contoursYellow){
            double score = calculateScore(cont); // Get the diffrence score using the scoring API

            // Get bounding rect of contour
            Rect rect = Imgproc.boundingRect(cont);
            Imgproc.rectangle(displayMat, rect.tl(), rect.br(), new Scalar(0,0,255),2); // Draw rect

            // If the result is better then the previously tracked one, set this rect as the new best
            if(score < bestDiffrence){
                bestDiffrence = score;
                bestRect = rect;
            }
        }

        // Vars to calculate the alignment logic.
        double leftX     = (getAdjustedSize().width / 3);
        double rightX    = (getAdjustedSize().width / 1.5);


        double xPos; // Current Gold X Pos
        double yPos; // Current Gold Y Pos


        if(bestRect != null){
            // Show chosen result
            Imgproc.rectangle(displayMat, bestRect.tl(), bestRect.br(), new Scalar(255,0,0),4);
            Imgproc.putText(displayMat, "Chosen", bestRect.tl(),0,1,new Scalar(255,255,255));

            // Set align X pos
            xPos = bestRect.x + (bestRect.width / 2);
            goldXPos = xPos;

            // Set Y pos
            yPos = bestRect.y + (bestRect.height / 2);
            goldYPos = yPos;
            // Draw center point
            Imgproc.circle(displayMat, new Point( xPos, bestRect.y + (bestRect.height / 2)), 5, new Scalar(0,255,0),2);

            // Make sure mineral is on ground and not some dude's shirt
            if (yPos < getAdjustedSize().height / 2) {
                // Check mineral position
                if (xPos < leftX) {
                    curGoldPos = GoldPosition.LEFT;
                } else if (xPos > rightX) {
                    curGoldPos = GoldPosition.RIGHT;
                } else {
                    curGoldPos = GoldPosition.MIDDLE;
                }
            }

            lastGoldPos = curGoldPos;

            // Draw Current X
            Imgproc.putText(displayMat,"Current X: " + bestRect.x,new Point(10,getAdjustedSize().height - 10),0,0.5, new Scalar(255,255,255),1);
            found = true;
        }else{
            found = false;
            curGoldPos = GoldPosition.NOT_FOUND;
        }
        if(debugAlignment){

            //Draw debug alignment info
            if(isFound()){
                Imgproc.line(displayMat,new Point(goldXPos, getAdjustedSize().height), new Point(goldXPos, getAdjustedSize().height - 30),new Scalar(255,255,0), 2);
                Imgproc.line(displayMat,new Point(getAdjustedSize().width, goldYPos), new Point(getAdjustedSize().width - 30, goldYPos), new Scalar(255,255,0), 2);
            }

            Imgproc.line(displayMat,new Point(leftX, getAdjustedSize().height), new Point(leftX, getAdjustedSize().height - 40), new Scalar(255,0,0));
            Imgproc.line(displayMat,new Point(rightX, getAdjustedSize().height), new Point(leftX, getAdjustedSize().height - 40), new Scalar(255,0,0));
        }

        //Print result
        Imgproc.putText(displayMat,"Result: " + curGoldPos.name(),new Point(10,getAdjustedSize().height - 30),0,1, new Scalar(255,255,0),1);


        return displayMat;

    }

    @Override
    public void useDefaults() {
        addScorer(ratioScorer);

        // Add diffrent scoreres depending on the selected mode
        if(areaScoringMethod == DogeCV.AreaScoringMethod.MAX_AREA){
            addScorer(maxAreaScorer);
        }

        if (areaScoringMethod == DogeCV.AreaScoringMethod.PERFECT_AREA){
            addScorer(perfectAreaScorer);
        }

    }

    /**
     * Returns gold element position (LEFT, MIDDLE, RIGHT, or NOT_FOUND)
     * @return gold element position as an enum value.
     */
    public GoldPosition getPosition(){
        return curGoldPos;
    }

    public GoldPosition getLastPosition() {
        return lastGoldPos;
    }

    /**
     * Returns gold element last x-position
     * @return last x-position in screen pixels of gold element
     */
    public double getXPosition(){
        return goldXPos;
    }

    /**
     * Returns if a gold mineral is being tracked/detected
     * @return if a gold mineral is being tracked/detected
     */
    public boolean isFound() {
        return found;
    }
}
