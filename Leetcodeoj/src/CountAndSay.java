public class CountAndSay {

	public String countAndSay(int n) {

		String[] res = new String[n];

		res[0] = "1";

		for (int i = 1; i < n; i++) {

			String base = res[i - 1];

			int count = 1;
			char cur = base.charAt(0);

			StringBuilder sb = new StringBuilder();

			for (int j = 1; j < base.length(); j++) {

				if (base.charAt(j) == cur)

					count++;

				else {

					sb.append(count).append(cur);

					count = 1;

					cur = base.charAt(j);

				}

			}
			sb.append(count).append(cur);
			res[i] = sb.toString();

		}

		return res[n - 1];

	}
	
	public static void main(String[] args){
		CountAndSay c =  new CountAndSay();
		System.out.println(c.countAndSay(3));
	}

}