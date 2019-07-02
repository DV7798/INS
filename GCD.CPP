#include<iostream.h>
#include<conio.h>

int main()
{
	int a,b,i,gcd,min;
	clrscr();
	cout<<"Enter the first Number ";
	cin>>a;
	cout<<"Enter the Second Number ";
	cin>>b;

	if(a>b)
	{
	min=b;
	}
	else
	min=a;

	for(i=min;i>0;i--)
	{
		if((a%i==0)&&(b%i==0))
		{
		gcd=i;
		break;
		}
	}
	cout<<"GCD is : "<<gcd<<endl;

	int n,c=0;

	cout<<"Enter the Number to check whether number is prime or not ";
	cin>>n;

	for(i=2;i<n;i++)
	{
		if(n%i==0)
		c++;
	}

	if(c==0)
	{
		cout<<n<<" is a Prime Number"<<endl;
	}
	else
	{
		cout<<n<<" is not a Prime Number"<<endl;
	}

	cout<<"Press any key to continue";
	cin>>a;

	cout<<"First 100 Prime Numbers are:\n";

	i=2,n=2;
	int t=0;

	while(t<100)
	{
		c=0;
		for(i=2;i<n;i++)
		{
		if(n%i==0)
		c++;
		}
		if(c==0)
		{
		cout<<"Prime Number "<<(t+1)<<" is "<<n<<endl;
		t++;
		}
		n++;
	}

	getch();
	return 0;
}