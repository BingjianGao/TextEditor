/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author Bingjian Gao
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
