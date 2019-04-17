#ifndef LIST_H
#define LIST_H

#include <stdlib.h>
#include <boolstd.h>

typedef struct node {
	void *data;
	struct node *next;
} node;

typedef struct {
	node *head;
	node *tail;
	int length;
} list;

node *make_node(void *);
void append(list *, void *);
bool is_empty(list *);

#endif // LIST_H
