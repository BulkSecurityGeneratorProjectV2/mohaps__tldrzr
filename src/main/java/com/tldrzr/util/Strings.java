/*
 *  
 *  TL;DRzr - A simple algorithmic summarizer
 *  Website: http://tldrzr.com
 *  Author: Saurav Mohapatra (mohaps@gmail.com)
 *  
 *  Copyright (c) 2016-2026, Saurav Mohapatra
 *  All rights reserved.
 *  
 *  
 *  
 *  Redistribution and use in source and binary forms, with or without modification, are permitted 
 *  provided that the following conditions are met:
 *  
 *  	a)  Redistributions of source code must retain the above copyright notice, 
 *  		this list of conditions and the following disclaimer.
 *  
 *  	b)  Redistributions in binary form must reproduce the above copyright notice, 
 *  		this list of conditions and the following disclaimer in the documentation 
 *  		and/or other materials provided with the distribution.
 *  	
 *  	c)  Neither the name of TL;DRzr nor the names of its contributors may be used 
 *  		to endorse or promote products derived from this software without specific 
 *  		prior written permission.
 *  
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 *  BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 *  SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 *  DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 *  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tldrzr.util;

public final class Strings {
	public static final String BLANK = "";

	public static final String join(String delimiter, Iterable<String> strings) {
		if (strings == null) {
			return BLANK;
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		boolean useDelimiter = isValidString(delimiter);
		for (String s : strings) {
			if (first) {
				first = false;
			} else if (useDelimiter) {
				sb.append(delimiter);
			}
			sb.append(s);
		}
		return sb.toString();
	}

	public static final String join(String delimiter, String... strings) {
		if (strings == null || strings.length == 0) {
			return BLANK;
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		boolean useDelimiter = isValidString(delimiter);
		for (String s : strings) {
			if (first) {
				first = false;
			} else if (useDelimiter) {
				sb.append(delimiter);
			}
			sb.append(s);
		}
		return sb.toString();
	}

	public static final boolean isValidString(String s) {
		return !(s == null || s.isEmpty());
	}

	public static final String removePunctuation(String s) {
		if (!isValidString(s)) {
			return BLANK;
		}
		return s.replaceAll("\\p{P}", "");
	}

	public static final String normalizeInput(String s) {
		if (!isValidString(s)) {
			return BLANK;
		}
		return s.trim().toLowerCase();
	}

	public static final String normalizeWord(String s) {
		if (!isValidString(s)) {
			return BLANK;
		}
		String trimmed = s.trim();
		if (!isValidString(trimmed)) {
			return BLANK;
		}
		return removePunctuation(trimmed.toLowerCase());
	}
}
