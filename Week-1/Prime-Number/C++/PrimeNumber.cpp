#include<iostream>
#include<vector>
#include<cstring>

// In C++ multiple fuctions may have same names. to avoid the naming collision we use namesapace.
// Using namespace std represents that all the functions have -> std::function_name()
// We do not have to input: std::function_name() every time
using namespace std;

// n -> max number that I will check
// marked -> bool array, that I mark composite numbers
// primes -> vector that contains primes from 2->n
// &primes -> reference alias or also known as (constant pointer)
// *marked -> pointer (Memory address)
// marked -> Only values
void sieve(long n, bool *marked, vector<int> &primes){
    for (long i = 2; i <= n; i++)
    {
        // push_back() -> Adds value as the last element
       if(!marked[i]) primes.push_back(i);
       for(long j=i*i;j<=n;j+=i) marked[j] = true;
    }
    
}

// print vector
void printVector(vector<int> vec){
    for (int i = 0; i < vec.size(); i++)
    {
        cout << vec[i] << " ";
        cout << endl << endl;
    }
    
}

// main function
int main() {
    long n;
    cin >> n;
    bool marked[n+1];
    // 1st arg: marked -> array, 2nd arg: false -> the value which will replace the 1st arg values, 3rd arg: marked -> Upto how many places
    // memset is use to modify the existing marked array with the given value upto a specific size of array
    memset(marked, false, sizeof marked);
    vector<int> primes;
    sieve(n,marked,primes);
    printVector(primes);
}