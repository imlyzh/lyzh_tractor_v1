import Chisel._


class Fetch extends Module {
  val io = IO(new Bundle {
    // val mem = Input(new Mem(UInt(64.W)))
    // val pc = Input(UInt(64.W))
    val out_inst = Output(UInt(32.W))
  })

  io.out_inst := "000000000001_00001_000_00001_0010011".U
}

