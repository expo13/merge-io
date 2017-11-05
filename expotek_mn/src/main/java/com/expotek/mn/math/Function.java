package com.expotek.mn.math;


public class Function {

    //essentially this contains an infinite list of points.. you should be able to plug in a point
    //and get a vector (tangent) and plug in a x,y,z value and get a point.

    //the goal here is to be both environment agnostic. That includes both type of vehicle and environment. Ie
    //putting software into a machine and through "calibration" the machines/software learns the controls
    //the nature of the environment. etc. Maybe plugins like vehicle plugins or other environments "plugins"
    //allow the software to adapt to the paremeters without a calibration. etc.

    //each input has an uncertainty/error and those inputs are looped through to get an aggregate or best
    //assumption of the trajectory of another vehicle. if no new input then the last known input from that
    //source is used - unless it is determined to be irrelevant. The inputs are a constant loop. ie

}