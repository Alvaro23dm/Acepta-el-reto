#include <stdio.h>

int main()
{
    int x, n, i, res;
    while(scanf("%d %d",&x,&n)>0)
    {
        res = 1;
        for(i = 0; i<n;i++)
        {
            res = ((res*x)+1)%1000007;
        }
        printf("%d\n",res);
    }
    return 0;
}
