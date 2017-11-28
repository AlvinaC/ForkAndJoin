import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CombinationProcessor extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	public String key;
	public ArrayList<Character> value;

	public CombinationProcessor(String key, ArrayList<Character> value) {
		this.key = key;
		this.value = value;
	}

	@Override
	protected Integer compute() {
		List<CombinationProcessor> tasks = new ArrayList<CombinationProcessor>();

		String temp;
		Integer count = 0;

		for (Character entry : value) {
			temp = key + entry;
			if (temp.length() == CandidateCode.level) {
				count++;
			} else {
				CombinationProcessor task = new CombinationProcessor(temp,
						CandidateCode.board.get(String.valueOf(entry)));
				task.fork();
				tasks.add(task);
			}
		}

		return addResultsFromTasks(count, tasks);

	}

	private Integer addResultsFromTasks(Integer count, List<CombinationProcessor> tasks) {
		for (CombinationProcessor item : tasks) {
			count = count + item.join();
		}
		return count;
	}

}
