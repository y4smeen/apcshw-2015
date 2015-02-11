public class Recursion {
    public void factorial(int n) {
	if (n > 0) {
            factorial(n - 1);
            System.out.println(n);
        }
    }

    public int fib(int n) {
	if (n == 0) {
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	else {
	    return fib(n-1) + fib(n-2);
	}
    }

    public int len(String s) {
	if (s.equals("")) {
	    return 0;
	} else {
	    return 1 + len(s.substring(1));
	}
    }
    
    public int count(String c, String s) {
	if (s.equals("")) return 0;
	else {
	    if (s.substring(0, 1).equals(c)) {
		return 1 + count(c, s.substring(1));
	    } else return count(c, s.substring(1));
	}
    }
    
    public int bunnyEars2(int bunnies) {
	if(bunnies == 0){
	    return 0;
	} else {
	    if (bunnies % 2 == 0) {
		return bunnyEars2(bunnies - 1) + 3;
	    } else {
		return bunnyEars2(bunnies - 1) + 2;
	    }
	}
    }

    public int strCount(String str, String sub) {
	if (str.length() < sub.length()) return 0;
	else {
	    if (str.substring(0, sub.length()).equals(sub)) {
		return 1 + strCount(str.substring(sub.length()), sub);
	    } else return 0 + strCount(str.substring(1), sub);
	}
    }

    public int sumDigits(int n) {
	if (n > 0) {
	    return (n%10) + sumDigits(n/10);
	} else return 0;
    }

    public String allStar(String str) {
	if (str.length() > 1) {
	    return str.substring(0, 1) + "*" + allStar(str.substring(1));
	} else if (str.length() == 1) {
	    return str;
	} else return "";
    }

    public static void main(String args[]) {
	Recursion r = new Recursion();
	r.factorial(5);
	System.out.println(r.len("omg"));
	System.out.println(r.count("c", "catcatcat"));
    }
}
