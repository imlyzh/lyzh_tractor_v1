import Chisel._


class Core extends Module {
  val io = IO(new Bundle {

  })

  val regfile = Module(new RegFile())

  val regfile_io = regfile.io

  val fetch = Module(new Fetch())
  val decode = Module(new Decode())
  val ex1 = Module(new Ex1())
  val wb = Module(new WriteBack())

  decode.io.inst := fetch.io.out_inst
  ex1.io.inst := decode.io.out
  wb.io.waddr := ex1.io.waddr
  wb.io.rd := ex1.io.rd
}
