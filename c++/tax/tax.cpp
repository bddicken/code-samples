/*
 * Computes a fixed tax for an income
 */
#include <iostream>

using namespace std;

const double TAX_RATE = 3.78;

int main () {

    cout << "\nEnter income: ";

    double income = 0.0;
    cin >> income;

    double tax_rate = (income/100.0) * TAX_RATE;

    cout << "\nYour tax is: " << tax_rate << "\n";

    return 0;
}
