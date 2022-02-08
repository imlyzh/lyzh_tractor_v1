import Chisel._


trait InstenceTractorSignal {
  def instence(): UInt
}

object InstType extends InstenceTractorSignal {
  def N   = "b000".U
  def R   = "b001".U
  def I   = "b010".U
  def S   = "b011".U
  def B   = "b100".U
  def U   = "b101".U
  def J   = "b110".U
  def instence() = UInt(3.W)
}

object ExecType extends InstenceTractorSignal {
  def csr = "b000".U
  def bru = "b001".U
  def lsu = "b010".U
  def alu = "b011".U

  def instence() = UInt(3.W)
}

/*
object SrcType extends InstenceTractorSignal {
  def literals = "b00".U
  def register = "b01".U
  def scr = "b10".U
  def pc = "b11".U

  def instence() = UInt(log2Up(4).W)
}
*/


object ALUType extends InstenceTractorSignal {
  def add   = "b0000".U

  def sub   = "b0001".U
  def sll   = "b0010".U

  def slt   = "b0011".U
  def sltu  = "b0100".U
  def xor   = "b0101".U
  def srl   = "b0110".U

  def sra   = "b0111".U

  def or    = "b1000".U
  def and   = "b1001".U

  def addw  = "b1010".U
  def subw  = "b1011".U
  def sllw  = "b1100".U
  def srlw  = "b1101".U
  def sraw  = "b1110".U

  def instence() = UInt(4.W)
}

object BRUType extends InstenceTractorSignal {
  def jal   = "b0000".U
  def jalr  = "b0001".U
  def beq   = "b0010".U
  def bne   = "b0011".U
  def blt   = "b0100".U
  def bge   = "b0101".U
  def bltu  = "b0110".U
  def bgeu  = "b0111".U

  def instence() = UInt(4.W)
}

object LSU extends InstenceTractorSignal {
  def lb   = "b0000".U
  def lh   = "b0001".U
  def lw   = "b0010".U
  def ld   = "b0011".U
  def lbu  = "b0100".U
  def lhu  = "b0101".U
  def lwu  = "b0110".U
  def sb   = "b1000".U
  def sh   = "b1001".U
  def sw   = "b1010".U
  def sd   = "b1011".U

  def instence() = UInt(4.W)
}

object CSROpType extends InstenceTractorSignal {
  def jmp  = "b000".U
  def wrt  = "b001".U
  def set  = "b010".U
  def clr  = "b011".U
  def wrti = "b101".U
  def seti = "b110".U
  def clri = "b111".U

  def instence() = UInt(3.W)
}
