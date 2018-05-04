#include <stdio.h>

void swapnubs(int *e, int *f) {	  
	int temp = *e;
	*e = *f;
	*f = temp;												                          
	printf("e is %d and f is %d\n", *e, *f);
}

void swapnums(int i, int j) {
	          int temp = i;
		              i = j;
			                    j = temp;
					    printf("j is %d and i is %d\n", i, j);
}

void swapnum(int &i, int &j) {
	  int temp = i;
	    i = j;
	      j = temp;
}

int main(void) {
	  int a = 10;
	    int b = 20;
	int c = 10;
	int d = 20;
	int *p -> *a;
	int *pi -> *b;
	swapnubs(p,pi);
//	swapnum(a, b);
	        printf("A is %d and B is %d\n", a, b);
		swapnum(a, b);
		printf("A is %d and B is %d\n", a, b);
//		                printf("c is %d and d is %d\n", c, d);
				return 0;
}
