#include <stdio.h>
#include <stdlib.h>

#define N 6

struct Graph {
	struct Node* head[N];
}

struct Node {
	int dest;
	struct Node* next;
}

struct Edge {
	int src, dest;
}

struct Graph createGraph(struct Edge edges[], int n) {	
	unsigned i;
	
	struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
	
	// initialize head pointer for all vertices
	for (i = 0; i < N; i++) 
		graph->head[i] = NULL;
	
	for (
}
