#include <iostream>
#include <string>

class EarthGravity
{

	private:
		std::string gravity;
		double SURFACE_EARTH_ACCLERATION;
	public:
		EarthGravity();
		void setGravity(std::string sGravity);
		std::string getGravity();
		double getEarthAcceleration();		
};
