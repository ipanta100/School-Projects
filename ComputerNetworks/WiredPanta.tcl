#Simulator
set ns [new Simulator]

#Nam trace file
set nf [open lan1.1.nam w]
$ns namtrace-all $nf

#Open Trace file
set tf [open lan1.1.tr w]
$ns trace-all $tf

#Procedure
proc finish {} {
        global ns nf tf
        $ns flush-trace
    #Close the trace file
        close $nf
    #Close the Trace file
        close $tf
    #Execute nam on the trace file
        exec nam lan1.1.nam &
        exit 0
}

for {set i 0} {$i < 30} {incr i} {
        set ni($i) [$ns node]
}

#Links for nodes
#[node n0]
$ns duplex-link $ni(0) $ni(1) 1Kb 10ms DropTail
$ns duplex-link $ni(0) $ni(3) 1Kb 10ms DropTail

#[subnodes for n0]
$ns duplex-link $ni(0) $ni(5) 1Kb 10ms DropTail
$ns duplex-link $ni(0) $ni(6) 1Kb 10ms DropTail
$ns duplex-link $ni(0) $ni(7) 1Kb 10ms DropTail
$ns duplex-link $ni(0) $ni(8) 1Kb 10ms DropTail
$ns duplex-link $ni(0) $ni(9) 1Kb 10ms DropTail

#[node n1]
$ns duplex-link $ni(1) $ni(0) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(2) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(4) 1Kb 10ms DropTail

#[subnodes for n1]
$ns duplex-link $ni(1) $ni(10) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(11) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(12) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(13) 1Kb 10ms DropTail
$ns duplex-link $ni(1) $ni(14) 1Kb 10ms DropTail

#[node n2]
$ns duplex-link $ni(2) $ni(1) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(3) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(4) 1Kb 10ms DropTail

#[subnodes for n2]
$ns duplex-link $ni(2) $ni(15) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(16) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(17) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(18) 1Kb 10ms DropTail
$ns duplex-link $ni(2) $ni(19) 1Kb 10ms DropTail

#[node n3]
$ns duplex-link $ni(3) $ni(0) 1Kb 10ms DropTail
$ns duplex-link $ni(3) $ni(2) 1Kb 10ms DropTail

#[subnodes for n3]
$ns duplex-link $ni(3) $ni(20) 1Kb 10ms DropTail
$ns duplex-link $ni(3) $ni(21) 1Kb 10ms DropTail
$ns duplex-link $ni(3) $ni(22) 1Kb 10ms DropTail
$ns duplex-link $ni(3) $ni(23) 1Kb 10ms DropTail
$ns duplex-link $ni(3) $ni(24) 1Kb 10ms DropTail

#[node n4]
$ns duplex-link $ni(4) $ni(1) 1Kb 10ms DropTail
$ns duplex-link $ni(4) $ni(2) 1Kb 10ms DropTail

#[subnodes for n4]
$ns duplex-link $ni(4) $ni(25) 1Kb 10ms DropTail
$ns duplex-link $ni(4) $ni(26) 1Kb 10ms DropTail
$ns duplex-link $ni(4) $ni(27) 1Kb 10ms DropTail
$ns duplex-link $ni(4) $ni(28) 1Kb 10ms DropTail
$ns duplex-link $ni(4) $ni(29) 1Kb 10ms DropTail

set udp0 [new Agent/UDP]
$ns attach-agent $ni(0) $udp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set null0 [new Agent/Null]
$ns attach-agent $ni(3) $null0

$ns connect $udp0 $null0

$ns at 0.5 "$cbr0 start"
$ns rtmodel-at 1.0 down $ni(1) $ni(2)
$ns rtmodel-at 2.0 up $ni(1) $ni(2)
$ns at 95 "$cbr0 stop"
$ns at 100.0 "finish"

#Run the simulation
$ns run