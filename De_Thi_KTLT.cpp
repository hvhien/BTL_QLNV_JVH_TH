#include<iostream>
#include<stdio.h>
#include<string.h>

using namespace std;

struct DoanhNghiep
{
	char Madn[20];
	char giamdoc[20];
	float vondieule;
	int sonhanvien;
};
void Nhap1dn(DoanhNghiep &x)
{
	fflush(stdin);
	cout<<"nhap ma doanh nghiep:";
	gets(x.Madn);
	cout<<"nhap ten giam doc:";
	fflush(stdin);
	gets(x.giamdoc);
	cout<<"nhap von dieu le:";
	cin>>x.vondieule;
	fflush(stdin);
	cout<<"nhap so nhan vien:";
	cin>>x.sonhanvien;
}
void Xuat1dn(DoanhNghiep &x)
{
	cout<<"ten doanh nghiep:"<<x.Madn<<"\t";
	cout<<"Ten giam doc:"<<x.giamdoc<<"\t";
	cout<<"Von dieu le:"<<x.vondieule<<"\t";
	cout<<"so nhan vien:"<<x.sonhanvien<<endl;
}
void NhapDanhSach(DoanhNghiep a[], int n)
{
	for(int i=0;i<n;i++)
	{
		Nhap1dn(a[i]);
		cout<<endl;
	}
}
void XuatDanhSach(DoanhNghiep a[], int n)
{
	for(int i=0;i<n;i++)
	{
		Xuat1dn(a[i]);
		cout<<endl;
	}
}
void SapXepDanhSach(DoanhNghiep a[], int n)
{
	DoanhNghiep temp;
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(a[i].vondieule>a[j].vondieule)
			{
				  temp=a[j];
				  a[j]=a[i];
				  a[i]=temp;
			}
		}
	}
}
void In(DoanhNghiep x)
{
	cout<<"MA DOANH NGHIEP:"<<x.Madn<<endl;
	cout<<"SO NHAN VIEN:"<<x.sonhanvien<<endl;
}
void LocChon(DoanhNghiep a[], int n)
{
	for(int i=0;i<n;i++)
	{
		if(a[i].sonhanvien>300&&a[i].Madn[0]=='D'&&a[i].Madn[1]=='N')
		{
			In(a[i]);
			cout<<endl;
		}
	}
}
int TimDauCach(char Madn[])
{
	for(int j=0;j<strlen(Madn);j++)
	{
		if(Madn[j]==' ')
			return 1;
	}
	return 0;
}
void DN_KhongHopLe(DoanhNghiep a[], int n)
{
	int dem=0;
	for(int i=0;i<n;i++)
	{
		if(a[i].vondieule<10||TimDauCach(a[i].Madn)==1)
			dem++;
	}
	cout<<"So doanh nghiep khong hop le:"<<dem<<endl;
}
int main()
{
	DoanhNghiep a[100];
	int n;
	cout<<"Nhap so doanh nghiep:";
	cin>>n;
	NhapDanhSach(a,n);
	XuatDanhSach(a,n);
	SapXepDanhSach(a,n);
	cout<<"\nSau khi sap xep danh sah:"<<endl;
	XuatDanhSach(a,n);
	cout<<"\ncac doanh nghiep co von>300 & madn bat dau='DN' la: "<<endl;
	LocChon(a,n);
	DN_KhongHopLe(a,n);
	return 0;
}
