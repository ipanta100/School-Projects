Computer Networks Project

The idea behind this project is to compare wired and wireless Lan with Awk Scripts.

Carrier-sense multiple access with collision detection (CSMA/CD) is the LAN access method used in Ethernet.
It is a set of rules determining how devices connected to a network respond when two devices try to utilize a channel simultaneously.
When a device wants to gain access to the network, it checks to see if the network is fee.
If the network is not free, the device waits a random amount of time before retrying.
If the network is free and two devices access the line at exactly the same time, their signals collide.
When the collision is detected, they both wait for another random interval of time before retrying. 

The probability p that fixed a host k acquires a time slot successfully is represented by the following equation 
p〖(1-p)〗^(k-1)

and the probability that some host acquires the slot is

=kp〖(1-p)〗^(k-1)

To minimize the probability of collision we set p = 1/k. 
For a fixed p as a function of k CSMA/CD under excessive load, throughput goes down.

802.11 Ad Hoc mode
IEEE 802.11 provides for roaming and mobility of 802.11 client devices and allows clients to roam among multiple 802.11
base stations that may be operating on the same or different frequencies.
This is achieved through the use of beacon frames which are used to synchronize 802.11 
devices and, in the infrastructure mode, to associate with a base station.

There are two ways to scan for existing 802.11 networks: active and passive scanning. 
In active scanning mode, the 802.11 device sends out probe frames, which existing 802.11 devices can respond to. 
In the passive mode, the devices just listen for beacon frames, which are periodically transmitted by the active devices 
