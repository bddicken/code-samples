#include <iostream>
#include <string.h>
#include "person.cpp"

using namespace std;


int main ()
{
    person abe = person("abe", 16, "I love cookies");
    person joe = person("joe", 18, "I love kershaw");
    person ben = person("ben", 20, "I love God");
    
    abe.speak();
    joe.speak();
    ben.speak();

    return 0;
}
