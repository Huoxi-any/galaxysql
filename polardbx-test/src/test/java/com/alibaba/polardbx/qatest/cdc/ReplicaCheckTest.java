/*
 * Copyright [2013-2021], Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.polardbx.qatest.cdc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Replica validation right after MySQL setup and before other real tests start to run
 *
 * @author siyu.yusi
 * @since 2022/3/22
 */
@Slf4j
public class ReplicaCheckTest extends CdcCheckTest {
    public static final String CHECK_CDC_READY_TOKEN = "check_cdc_ready_token";

    @Test
    public void CheckCdcStatus() {
        checkStatus();
    }

    @Test
    public void checkData() throws SQLException, InterruptedException {
        sendCdcToken(CHECK_CDC_READY_TOKEN, 1);
        waitCdcToken(CHECK_CDC_READY_TOKEN, 1);
        doCheck(1);
    }
}
