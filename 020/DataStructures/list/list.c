void append(list *l, void *data)
{
	if (is_empty(l))
	{
		l->head = l->tail = make_node(data);
		l->length = 1;
		return;
	}
	node *tmp = make_node(data);
	l->tail->next = tmp;
	l->tail = l->tail->next;
	l->length++;
}

bool is_empty(list *l)
{
	if (l->head == NULL || l->tail == NULL || l->length == 0)
		return true;
	return false;
}

node *make_node(void *data)
{
	node *tmp = (node *) malloc(sizeof(node));
	tmp->data = data;
	tmp->next = NULL;
	return tmp;
}

