/*
Professor Keith Smelser
Tarrant County College - COSC 1437
Semester 2021
Zane Sanchez
*/


#include <iostream>
#include <iomanip>
#include <memory>
#include <string>
#include <cstring>
using namespace std;

struct SalesInfo
{
   int itemNum;
   string itemName;
   int itemQuant;
   double tCost;                          // Total Cost
   long CCN;                              // Credit Card Number
   string CCname;                         // Credit Card Name
   int CCexp;                             // Credit Card Expiration Date MM/YY
   int CCSC;                              // Credit Card Security Code
   bool isValid = false;
};



void displaySales(SalesInfo sale)
{
   cout << "Item Number:                 " << sale.itemNum<<endl;
   cout << "Item Name:                   " << sale.itemName << endl;
   cout << "Item Quantity:               " << sale.itemQuant << endl;
   cout << fixed<<setprecision(2);
   cout << "Total Cost:                  " << "$"<<sale.tCost << endl;
   cout << "Credit Card Number:          " << sale.CCN << endl;
   cout << "Credit Card User Name:       " << sale.CCname << endl;
   cout << "Credit Card Expiration Date: " << sale.CCexp << endl;
   cout << "Credit Card Security Number: " << sale.CCSC << endl;
}

void preCheck(SalesInfo& sale)
{
   SalesInfo a = { 1001,"Foam Padding",1,8.50 };                           // Existing Products listed here
   SalesInfo b = { 1002,"Box Tape",1,10.11 };
   SalesInfo c = { 1003,"Moving Blanket",1,20.00 };
   SalesInfo d = { 1004,"Moving Box",1,4.25 };

   if(sale.itemNum == a.itemNum)                                           // Maybe use arrays to make program more dynamic
   {
      sale.itemName = a.itemName;
      sale.tCost = (sale.itemQuant * a.tCost);
      sale.isValid = true;
   }
   if (sale.itemNum == b.itemNum)
   {
      sale.itemName = b.itemName;
      sale.tCost = (sale.itemQuant * b.tCost);
      sale.isValid = true;
   }
   if (sale.itemNum == c.itemNum)
   {
      sale.itemName = c.itemName;
      sale.tCost = (sale.itemQuant * c.tCost);
      sale.isValid = true;
   }
   if (sale.itemNum == d.itemNum)
   {
      sale.itemName = d.itemName;
      sale.tCost = (sale.itemQuant * d.tCost);
      sale.isValid = true;
   }
   
}

int main()
{
   cout << boolalpha;
   SalesInfo user;
   cout << "Please Enter the Item Number ";
   cin >> user.itemNum;
   cout << "\nPlease Enter the Item Quantity ";
   cin >> user.itemQuant;
   cout << endl;
   preCheck(user);
   if(user.isValid==true)
   {
      cout << "Please Enter Credit Card Number ";
      cin >> user.CCN;
      cout << "\nPlease Enter Credit Card User Name ";
      cin >> user.CCname;
      cout << "\nPlease Enter Credit Card Expiration Date ";
      cin >> user.CCexp;
      cout << "\nPlease Enter Credit Card Security Code ";
      cin >> user.CCSC;
      cout << endl;
      displaySales(user);

   }else
   {
      cout << "Could not find item" << endl;
   }

   return 0;

}
