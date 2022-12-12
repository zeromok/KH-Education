package GenericMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Pair<K, V> {

  private K key;
  private V value;

} // end class
