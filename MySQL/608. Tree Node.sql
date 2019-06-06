
/*

Given a table tree, id is identifier of the tree node and p_id is its parent node's id.
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+
Each node in the tree can be one of three types:
Leaf: if the node is a leaf node.
Root: if the node is the root of the tree.
Inner: If the node is neither a leaf node nor a root node.
Write a query to print the node id and the type of the node. Sort your output by the node id. 

The result for the above sample is:
+----+------+
| id | Type |
+----+------+
| 1  | Root |
| 2  | Inner|
| 3  | Leaf |
| 4  | Leaf |
| 5  | Leaf |
+----+------+

*/

SELECT t.id, 
IF(ISNULL(t.p_id), 'Root', IF(t.id IN (SELECT p_id FROM tree), 'Inner', 'Leaf')) AS Type
FROM tree t


