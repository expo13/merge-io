#include <iostream>
#include <string>
#include "EarthGravity.h"
using namespace std;
void testOut();
void print(std::string input);
void print(double input);

int main()
{
	cout << "Hello World" << endl; 
	testOut();
	EarthGravity eG;
	std::string testies = "TESTIES" ;
	print(testies);
	eG.setGravity(testies);
	print(eG.getGravity());
	print(eG.getEarthAcceleration());
	return 0;
}

void print(std::string input)
{
	    cout << input << endl;
}


void print(double input)
{	            cout << input << endl;
}

void testOut(){
	cout << "TEST" << endl;
}

