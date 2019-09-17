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
package org.hyperledger.besu.ethereum.api.jsonrpc.internal.methods;

import org.hyperledger.besu.ethereum.api.jsonrpc.RpcMethod;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.JsonRpcRequest;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcResponse;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcSuccessResponse;

public class EthSubmitLogin implements JsonRpcMethod {

  @Override
  public String getName() {
    return RpcMethod.ETH_SUBMIT_LOGIN.getMethodName();
  }

  @Override
  public JsonRpcResponse response(final JsonRpcRequest req) {
    // Confirm login request. Mining pools use this method for adding new users/rigs to their
    // database for payouts and fees
    // Here, this just confirms connection requests by any mining software, allowing mining software
    // to start work
    boolean result = true;
    return new JsonRpcSuccessResponse(req.getId(), result);
  }
}
