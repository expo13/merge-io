#include "EarthGravity.h"

EarthGravity::EarthGravity()
{
	SURFACE_EARTH_ACCLERATION = 9.81;
}

void EarthGravity::setGravity(std::string sGravity)
{
	gravity = sGravity;
}

std::string EarthGravity::getGravity()
{
	return gravity;
}

double EarthGravity::getEarthAcceleration(){

	return SURFACE_EARTH_ACCLERATION;
	//	return 9.81;
}

