import Chisel._


class DecodeOutput extends Bundle {
  val inst_type = InstType.instence()
  val exec_type = UInt(4.W)
  val op_type = UInt(4.W)

  val rd_imm04_imm1411 = UInt(5.W)
  val funct3 = UInt(3.W)
  val rs1 = UInt(5.W)
  val rs2 = UInt(5.W)
  val funct7_imm = UInt(7.W)
}

class DecodeIO extends Bundle {
  val inst = Input(UInt(32.W))

  val out = Output(Reg(new DecodeOutput))
}

class Decode extends Module {
  val io = IO(new DecodeIO)

  val inst = io.inst

  val decode_result = ListLookup(inst, Instructions.Default, Instructions.DecodeMap)

  val inst_type :: exec_type :: op_type :: Nil = decode_result

  io.out.inst_type := inst_type
  io.out.exec_type := exec_type
  io.out.op_type := op_type

  val rd_imm04_imm1411 = inst(11, 7)
  val funct3 = inst(14, 12)
  val rs1 = inst(19, 15)
  val rs2 = inst(24, 20)
  val funct7_imm = inst(31, 25)

  io.out.rd_imm04_imm1411 := rd_imm04_imm1411
  io.out.funct3 := funct3
  io.out.rs1 := rs1
  io.out.rs2 := rs2
  io.out.funct7_imm := funct7_imm

}