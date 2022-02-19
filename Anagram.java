

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;



// classe para representar uma substring em termos de frequencia 
// dos char presentes na substring
class Substring {
	int MOD = 1000000007;

	// array para contar chars
	int count[];
	Substring() { count = new int[26]; }

	// hash para cada char
    public int hashCode()
	{
		int hash = 0;
		for (int i = 0; i < 26; i++) {
			hash += (i + 1) * count[i];
			hash %= MOD;
		}
		return hash;
	}

    // compara objs
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Substring))
			return false;
		Substring ob = (Substring)o;
		for (int i = 0; i < 26; i++) {
			if (ob.count[i] != count[i])
				return false;
		}
		return true;
	}
}

// a ideia eh iterar a string e gerar a frequencia das substring utilizando o array prefix
class Anagram {

	// funcao para checar anagrama
	public static String checkForAnagrams(String s, int n, int k)
	{
        String anagrams = "";
		// Array prefix para guardar a frequencia
		// de chars
		int prefix[][] = new int[n + 1][26];
		for (int i = 0; i < n; i++) {
			prefix[i][s.charAt(i) - 97]++;
		}

		// gera a soma dos prefix
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 26; j++)
				prefix[i][j] += prefix[i - 1][j];
		}

		// Map para armazenar frequencia
		HashMap<Substring, Integer> map
			= new HashMap<>();

		// Checa anagramas
		for (int i = 0; i < n; i++) {
			if (i + k > n)
				break;

			// Gera frequencia de chars
			// da subtring comecando de i
			Substring sub = new Substring();
			for (int j = 0; j < 26; j++) {
				sub.count[j]
					= prefix[i + k - 1][j]
					- (i - 1 >= 0
							? prefix[i - 1][j]
							: 0);
			}


			// se ja esta presente no Hashmap
			if (map.containsKey(sub)) {
				// Anagramas
				anagrams =
					s.substring(map.get(sub),
								map.get(sub) + k)
					+ " " + s.substring(i, i + k);
				break;
			}
			else {
				map.put(sub, i);
			}
		}
        return anagrams;
	}

	public static String countAnagrams(String s){
		String anagrams = "";
        int cont = 0;
		int n = s.length();

        for(int i = 1; i<=n; i++){
            anagrams = checkForAnagrams(s, n, i);
            if(!anagrams.isEmpty() ){
                System.out.println(anagrams);
                cont++;
            }
        }

		return cont + "";
	}

	
	public static void main(String[] args)
	{
		
        System.out.println(countAnagrams("ifailuhkqq"));
	}

	@Test
	public void testAnagram(){
		assertEquals(3,countAnagrams("ifailuhkqq"));
		assertEquals(2,countAnagrams("ovo"));
	}
}
