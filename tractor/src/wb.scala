
import Chisel._


class WriteBack extends Module {
  val io = IO(new Bundle {
    val reg = Input(new RegFileIO)
    val waddr = Input(UInt(5.W))
    val rd = Input(UInt(5.W))
  })

  io.reg.wen := true.B
  io.reg.waddr := io.waddr
  io.reg.rd := io.rd
}