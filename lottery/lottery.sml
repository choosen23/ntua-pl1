fun lottery file =
    let
    fun parse file =
            let
            (* A function to read an integer from specified input. *)
                fun readInt input =
                    Option.valOf (TextIO.scanStream (Int.scan StringCvt.DEC) input)

                (* Open input file. *)
                val inStream = TextIO.openIn file

                (* Read an integers for lottery *)
                val K = readInt inStream
                val N = readInt inStream 
                val Q = readInt inStream
                val _ = TextIO.inputLine inStream

                (* A function to read N integers from the open file. *)
                fun readInts 0 acc = rev acc (* 'rev acc' for proper order. *)
                  | readInts i acc = readInts (i - 1) (readInt inStream :: acc)
            in
                (K, N, Q, (readInts n []))
            end

        val (K,N,Q,List) = parse file


        in
           print "0/n"
        end

