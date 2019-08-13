fun colors file =
    let

        fun parse file =
            let
            (* A function to read an integer from specified input. *)
                fun readInt input =
                    Option.valOf (TextIO.scanStream (Int.scan StringCvt.DEC) input)

                (* Open input file. *)
                val inStream = TextIO.openIn file

                (* Read an integer (number of countries) and consume newline. *)
                val n = readInt inStream
                val k = readInt inStream (* Chariton's Only Modification *)
                val _ = TextIO.inputLine inStream

                (* A function to read N integers from the open file. *)
                fun readInts 0 acc = rev acc (* 'rev acc' for proper order. *)
                  | readInts i acc = readInts (i - 1) (readInt inStream :: acc)
            in
                (n, k, (readInts n []))
            end

        val (n,k, a) = parse file

        fun zeros 0 = []
            | zeros n = (0::(zeros (n-1)))

        val occurences =
            let
                fun count_occurences occurences [] = occurences
                    | count_occurences occurences (x::xs) = (
                        Array.update(occurences, x, (Array.sub(occurences, x) + 1));
                        count_occurences occurences xs )
            in
                count_occurences (Array.fromList (zeros (k+1))) a
            end

        fun arrayToList arr = Array.foldr (op ::) [] arr

        fun headless [] = []
            | headless (x::xs) = xs

        fun missing_color [] = false
            | missing_color (x::xs) = if x<1 then true else missing_color xs

        fun solve1 occurences [] = 0
            | solve1 occurences (x::xs) =
                if (Array.sub(occurences, x) > 1) then (Array.update(occurences, x, Array.sub(occurences, x) - 1); solve1 occurences xs)
                else length (x::xs)

        fun solve2 occurences [] = 0
            | solve2 occurences (x::xs) =
                if (Array.sub(occurences, x) > 1) then (Array.update(occurences, x, Array.sub(occurences, x) - 1); solve2 occurences xs)
                else solve1 occurences (rev (x::xs))

        in
            if (missing_color (headless (arrayToList occurences))) then print "0\n"
            else print ((Int.toString (solve2 occurences a) ^ "\n"))
        end
