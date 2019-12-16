BEGIN {
    RecSize = 0
    TranSize = 0
    StartTime = 400
    StopTime = 0
}

{
    Event = $1
    Time = $2
    SendId = $3
    RecId = $4
    PktSize = $6
    FlowId = $8

    # Store start time
    if (SendId == "0") {
        if (Time < StartTime) {
            StartTime = Time
        }

        if (Event == "+") {
            TranSize += PktSize
        }
    }

    # Update total received packets size and store packets arrival time
    if (Event == "r" && RecId == "2") {
        if (Time > StopTime) {
            StopTime = Time
        }
        # Store received packet's size
        if (FlowId == "1") {
            RecSize += Pkt_size
        }
    }
}

END {
    printf("%i\t%i\t%.2f\t%.2f\n", transSize, recvdSize, startTime, stopTime)
}
