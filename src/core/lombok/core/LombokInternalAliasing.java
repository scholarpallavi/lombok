/*
 * Copyright (C) 2013 The Project Lombok Authors.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LombokInternalAliasing {
	public static final Map<String, String> IMPLIED_EXTRA_STAR_IMPORTS;
	public static final Map<String, String> ALIASES;
	
	/**
	 * Provide a fully qualified name (FQN), and the canonical version of this is returned.
	 */
	public static String processAliases(String in) {
		if (in == null) return null;
		for (Map.Entry<String, String> e : ALIASES.entrySet()) {
			if (in.equals(e.getKey())) return e.getValue();
		}
		return in;
	}
	
	static {
		Map<String, String> m = new HashMap<String, String>();
		m.put("lombok.experimental", "lombok");
		IMPLIED_EXTRA_STAR_IMPORTS = Collections.unmodifiableMap(m);
		
		m = new HashMap<String, String>();
		m.put("lombok.experimental.Value", "lombok.Value");
		ALIASES = Collections.unmodifiableMap(m);
	}
}
