import { Depense } from "./depense.model";
import { UserSummary } from "./user-summary.model";

export interface Sortie {
  id: number;
  name: string;
  CreatedById: number;
  users: UserSummary[];
  depenses: Depense[];
}