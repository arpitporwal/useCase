package usecase.mapreduce;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MapReduceStream
{
	private static final String FILENAME = "C:\\Users\\aporw3\\git\\useCase\\CustomClassLoader\\src\\usecase\\mapreduce\\mapreducefile.txt";

	public static void main(String[] args) throws URISyntaxException, IOException
	{
		File file = new File(FILENAME);
		Path path = Paths.get(file.toURI());
		
		Stream<String> lines = Files.lines(path);
		
		Stream<Map<String, Integer>> s1 = lines.map(a -> {
			Map<String, Integer> map = new HashMap<String, Integer>();
			String[] array = a.split("\\s");
			for(String tmp : array)
			{
				if(map.containsKey(tmp))
				{
					map.put(tmp, map.get(tmp)+1);
				}
				else
				{
					map.put(tmp, 1);
				}
			}
			return map;
		});

		Map<String, Integer> s2 = s1.reduce(new HashMap<String, Integer>(), (a, b) -> {
			for(Map.Entry<String, Integer> entry : b.entrySet())
			{
				a.merge(entry.getKey(), entry.getValue(), (v1, v2) -> v1+v2);
			}
			return a;
		});
		s2.entrySet().stream().forEach(a -> System.out.println(a.getValue()+" "+a.getKey()));
		
		/*lines.forEach((a) -> {
			System.out.println(a);
		});*/
		lines.close();

	}
}
