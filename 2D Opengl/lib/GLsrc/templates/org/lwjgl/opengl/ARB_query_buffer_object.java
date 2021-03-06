/*
 * Copyright (c) 2002-2013 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opengl;

public interface ARB_query_buffer_object {

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetQueryObjectiv, GetQueryObjectuiv,
	 * GetQueryObjecti64v and GetQueryObjectui64v:
	 */
	int GL_QUERY_RESULT_NO_WAIT = 0x9194;

	/**
	 * Accepted by the &lt;target&gt; parameter of BindBuffer, BufferData,
	 * BufferSubData, MapBuffer, UnmapBuffer, MapBufferRange, GetBufferSubData,
	 * GetBufferParameteriv, GetBufferParameteri64v, GetBufferPointerv,
	 * ClearBufferSubData, and the &lt;readtarget&gt; and &lt;writetarget&gt; parameters of
	 * CopyBufferSubData:
	 */
	int GL_QUERY_BUFFER = 0x9192;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv,
	 * and GetDoublev:
	 */
	int GL_QUERY_BUFFER_BINDING = 0x9193;

	/** Accepted in the &lt;barriers&gt; bitfield in MemoryBarrier: */
	int GL_QUERY_BUFFER_BARRIER_BIT = 0x00008000;

}