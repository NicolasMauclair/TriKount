import { UserSummary } from "./user-summary.model";

export interface Depense {
  id: number;
  name: string;
  price: number;
  PayedById: number;
  usersId: number[];
}
