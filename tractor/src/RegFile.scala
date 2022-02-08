import Chisel._

class RegFileIO extends Bundle {
  val wen = Input(Bool())
  val waddr = Input(UInt(5.W))
  val rd = Input(UInt(32.W))

  val ren = Input(Bool())
  val rs1addr = Input(UInt(5.W))
  val rs2addr = Input(UInt(5.W))
  val rs1 = Output(UInt(32.W))
  val rs2 = Output(UInt(32.W))
}

class RegFile extends Module {
  val io = IO(new RegFileIO)

  val regs = Mem(31, UInt(64.W))

  when (io.wen) {
    when (io.waddr =/= 0.U) {
      regs(io.waddr-1.U) := io.rd
    }
  }

  when (io.ren) {
    when (io.rs1addr =/= 0.U) {
      io.rs1 := regs(io.rs1addr-1.U)
      io.rs2 := regs(io.rs2addr-1.U)
    }
    io.rs1 := 0.U
    io.rs2 := 0.U
  }
}