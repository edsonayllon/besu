/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.hyperledger.besu.ethereum.vm.operations;

import org.hyperledger.besu.ethereum.core.Gas;
import org.hyperledger.besu.ethereum.vm.AbstractOperation;
import org.hyperledger.besu.ethereum.vm.GasCalculator;
import org.hyperledger.besu.ethereum.vm.MessageFrame;
import org.hyperledger.besu.util.bytes.Bytes32;
import org.hyperledger.besu.util.uint.UInt256;

public class MLoadOperation extends AbstractOperation {

  public MLoadOperation(final GasCalculator gasCalculator) {
    super(0x51, "MLOAD", 1, 1, false, 1, gasCalculator);
  }

  @Override
  public Gas cost(final MessageFrame frame) {
    final UInt256 offset = frame.getStackItem(0).asUInt256();

    return gasCalculator().mLoadOperationGasCost(frame, offset);
  }

  @Override
  public void execute(final MessageFrame frame) {
    final UInt256 location = frame.popStackItem().asUInt256();

    final Bytes32 value = Bytes32.leftPad(frame.readMemory(location, UInt256.U_32));

    frame.pushStackItem(value);
  }
}
