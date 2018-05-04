#include <iostream>
#include <string>

class Auto 
{

	private:
		int mass;
		double speed;
		Auto front, behind;
	public:
		Auto();
		Auto(int x, double s)
		{
			mass = x;
			speed = s;
		}
}
