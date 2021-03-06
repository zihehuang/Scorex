package examples.trimchain.blockchain

import examples.commons.SimpleBoxTransaction
import examples.trimchain.modifiers.{TBlock, TModifier}
import scorex.core.NodeViewModifier.ModifierId
import scorex.core.block.BlockValidator
import scorex.core.consensus.History
import scorex.core.consensus.History.{HistoryComparisonResult, ModifierIds, ProgressInfo}
import scorex.core.transaction.box.proposition.PublicKey25519Proposition
import scorex.core.utils.ScorexLogging

import scala.util.Try

class TrimChain(version: ModifierId,
                validators: Seq[BlockValidator[TBlock]])
  extends History[PublicKey25519Proposition,
    SimpleBoxTransaction,
    TModifier,
    TrimChainSyncInfo,
    TrimChain] with ScorexLogging {

  /**
    * Is there's no history, even genesis block
    */
  override def isEmpty: Boolean = ???

  override def modifierById(modifierId: ModifierId): Option[TModifier] = ???

  override def append(modifier: TModifier): Try[(TrimChain, ProgressInfo[TModifier])] = ???

  override def drop(modifierId: ModifierId): TrimChain = ???

  override def openSurfaceIds(): Seq[ModifierId] = ???

  override def continuationIds(from: ModifierIds, size: Int): Option[ModifierIds] = ???

  override def syncInfo(answer: Boolean): TrimChainSyncInfo = ???

  /**
    * Whether another's node syncinfo shows that another node is ahead or behind ours
    *
    * @param other other's node sync info
    * @return Equal if nodes have the same history, Younger if another node is behind, Older if a new node is ahead
    */
  override def compare(other: TrimChainSyncInfo): HistoryComparisonResult.Value = ???

  override type NVCT = this.type
}
