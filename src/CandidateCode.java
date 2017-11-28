
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.sql.PooledConnection;

public class CandidateCode {

	static int level = 0;
	static HashMap<String, ArrayList<Character>> board = new HashMap<String, ArrayList<Character>>();
	public ForkJoinPool pool = new ForkJoinPool();
	public static List<CombinationProcessor> taskList = new ArrayList<CombinationProcessor>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		output = new CandidateCode().combinationCounts(ip1);
		System.out.println(String.valueOf(output));
	}

	public int combinationCounts(int ip1) {
		level = ip1;
		CandidateCode t = new CandidateCode();
		t.formBoard();
		if (level == 0)
			return 0;
		else if (level == 1)
			return (board.size());
		else {
			t.count();
			do {
				System.out.printf("******************************************\n");
				System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
				System.out.printf("******************************************\n");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while ((!taskList.get(0).isDone()) || (!taskList.get(1).isDone()) || (!taskList.get(2).isDone())
					|| (!taskList.get(3).isDone()) || (!taskList.get(4).isDone()) || (!taskList.get(5).isDone())
					|| (!taskList.get(6).isDone()) || (!taskList.get(7).isDone()) || (!taskList.get(8).isDone())
					|| (!taskList.get(9).isDone()));
			pool.shutdown();
			Integer count = 0;
			for (CombinationProcessor task : taskList) {
				count = count + task.join();
			}
			return count;
		}
	}

	private void count() {
		for (Map.Entry<String, ArrayList<Character>> entry : board.entrySet()) {
			String key = entry.getKey();
			ArrayList<Character> value = entry.getValue();
			CombinationProcessor recCall = new CombinationProcessor(key, value);
			taskList.add(recCall);
		}
		for (CombinationProcessor task : taskList)
			pool.execute(task);
	}

	public void formBoard() {
		ArrayList<Character> a = new ArrayList<Character>();
		a.add('A');
		a.add('B');
		a.add('D');
		ArrayList<Character> b = new ArrayList<Character>();
		b.add('B');
		b.add('A');
		b.add('C');
		b.add('E');
		ArrayList<Character> c = new ArrayList<Character>();
		c.add('C');
		c.add('B');
		c.add('F');
		ArrayList<Character> d = new ArrayList<Character>();
		d.add('D');
		d.add('A');
		d.add('E');
		d.add('G');
		ArrayList<Character> e = new ArrayList<Character>();
		e.add('E');
		e.add('B');
		e.add('D');
		e.add('F');
		e.add('H');
		ArrayList<Character> f = new ArrayList<Character>();
		f.add('F');
		f.add('C');
		f.add('E');
		f.add('I');
		ArrayList<Character> g = new ArrayList<Character>();
		g.add('G');
		g.add('D');
		g.add('H');
		ArrayList<Character> h = new ArrayList<Character>();
		h.add('H');
		h.add('E');
		h.add('G');
		h.add('I');
		h.add('J');
		ArrayList<Character> i = new ArrayList<Character>();
		i.add('I');
		i.add('F');
		i.add('H');
		ArrayList<Character> j = new ArrayList<Character>();
		j.add('J');
		j.add('H');
		board.put("A", a);
		board.put("B", b);
		board.put("C", c);
		board.put("D", d);
		board.put("E", e);
		board.put("F", f);
		board.put("G", g);
		board.put("H", h);
		board.put("I", i);
		board.put("J", j);
	}
}
