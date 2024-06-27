- To check if there are any active entwork connections/listening services on selected port
- To check which IP addresses are involved in these connections

Enter this in CMD Prompt (Make sure to run as admin.):
netstat -na | find "Enter port here"

Breakdown:
<netstat -na> displays network connections, routing tables, interface statistics, & multicast memberships
