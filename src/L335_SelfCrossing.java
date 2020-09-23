// 335. Self Crossing

/*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
public class L335_SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int l = x.length;
        if (l <= 3) return false;

        for (int i = 3; i < l; i++) {
            /*                   i-2
                    case 1 : i-1┌─┐
                                └─┼─>i
                                i-3
             */
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;  //Fourth line crosses first line and onward
            /*
                                  i-2
                    case 2 : i-1 ┌────┐
                                 └─══>┘i-3
                                 i  i-4
             */
            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                    return true;
            }
            /*
                case 3 :   i-4
                           ┌──┐
                           │i<┼─┐
                        i-3│ i-5│i-1
                           └────┘
                            i-2
             */
            if (i >= 5) {
                if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                    return true;
            }
        }
        return false;
    }
}
