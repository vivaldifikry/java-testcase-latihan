SELECT 
    c.iban, 
    b.amount,
	COUNT(t.transaction_amount) AS total_transaction
FROM 
    customers c
JOIN 
    balances b ON c.id = b.customer_id
JOIN 
    transactions t ON c.id = t.customer_id
WHERE
	b.amount < 0
GROUP BY 
    c.iban, b.amount
ORDER BY
	b.amount ASC;
