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
package com.tldrzr.nlp;

import java.io.InputStream;
import java.util.Set;

import com.tldrzr.util.Streams;

public final class Paths {
	public static final String NLP_ROOT = "nlp";

	public static final String getLanguagePath(String language) {
		return NLP_ROOT + "/" + language;
	}

	public static final String getSentenceModelPath(String language) {
		return getLanguagePath(language) + "/" + language + "-sent.bin";
	}

	public static final String getTokenModelPath(String language) {
		return getLanguagePath(language) + "/" + language + "-token.bin";
	}

	public static final String getStopwordsPath(String language) {
		return getLanguagePath(language) + "/" + language + "-stopwords.txt";
	}

	public static final InputStream getSentenceModelStream(String language) throws Exception {
		return Streams.openResource(getSentenceModelPath(language));
	}

	public static final InputStream getTokenModelStream(String language) throws Exception {
		return Streams.openResource(getTokenModelPath(language));
	}

	public static final InputStream getStopwordsStream(String language) throws Exception {
		return Streams.openResource(getStopwordsPath(language));
	}

	public static final Set<String> getStopwordsSet(String language) throws Exception {
		return Streams.loadSet(getStopwordsPath(language));
	}
}