#include <iostream>
#include <string.h>

using namespace std;

class person
{

    public:
        string name;
        int age;
        string favorite_saying;

    public:
        person (string a_name, int a_age, string a_favorite_saying) 
        {
            name = a_name;
            age = a_age;
            favorite_saying = a_favorite_saying;
        }

        void speak () 
        {
            cout << name << " says: \"" << favorite_saying << "\"\n";
        }

};
