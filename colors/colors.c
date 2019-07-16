          
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {

    FILE *fp;
    char* file_name =  argv[1];
    fp = fopen(file_name, "r");

    if (fp == NULL){
        perror("Error while opening the file.\n");
        exit(EXIT_FAILURE);
    }

    int n, k;
    fscanf(fp, "%d", &n);
    fscanf(fp, "%d", &k);

    int a[n], occurences[k+1];

    for (int i=0; i<n; i++){
        fscanf(fp, "%d", &a[i]);
        if (i<k+1){
            occurences[i] = 0;
        }
    }

    for (int i=0; i<n; i++){
        occurences[a[i]]++; // counting occurences of each integer in a
    }

    for (int i=1; i<k+1; i++){
        if (occurences[i] == 0){  // if some number in [1, k] is missing,
            printf("0\n");       // then answer is 0
            return 0;
        }
    }

    int lower=0, upper=n-1;

    while(42) {
        if (occurences[a[lower]] > 1) {
            occurences[a[lower]]--;
            lower++;
        }
        else if (occurences[a[upper]] > 1){
            occurences[a[upper]]--;
            upper--;
        }
        else {
            break;
        }
    }

    printf("%d\n", upper-lower+1);
    return 0;

}

