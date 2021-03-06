/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.util.internal;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadLocalRandomTest {

    @Test
    public void getInitialSeedUniquifierPreservesInterrupt() {
        try {
            Thread.currentThread().interrupt();
            assertTrue("Assert that thread is interrupted before invocation of getInitialSeedUniquifier()",
                    Thread.currentThread().isInterrupted());
            ThreadLocalRandom.getInitialSeedUniquifier();
            assertTrue("Assert that thread is interrupted after invocation of getInitialSeedUniquifier()",
                    Thread.currentThread().isInterrupted());
        } finally {
            Thread.interrupted(); // clear interrupted status in order to not affect other tests
        }
    }

    // 和老徐排查一个问题
    @Test
    public void testYunai() {
        System.out.println(-1 >>> 1);
        System.out.println(0 >>> 1);
        System.out.println(1 >>> 1);

        System.out.println(-1 % 10);
        System.out.println(-1 % 10);

    }

}